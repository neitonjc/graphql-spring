package com.neitonjc.graphql.resolver;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.neitonjc.graphql.input.PessoaInput;
import com.neitonjc.graphql.model.Pessoa;
import com.neitonjc.graphql.repository.PessoaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
public class PessoaResolver implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {
	
	@Autowired
	private PessoaRepository rep;
	
	private ConcurrentHashMap<Integer, FluxSink<Pessoa>> peopleSubscribers = new ConcurrentHashMap<>();
	
	public Collection<Pessoa> findAllPeople(){
		return rep.findAll();
	}
	
	public Pessoa findPeopleById(Integer cod) {
		return rep.findById(cod).orElse(null);
	}
	
	public Pessoa savePeople(PessoaInput p) {
		return rep.save(new Pessoa(p.nome, p.email, p.genero));
	}
	
	public Pessoa updateEmail(Integer peopleId, String email) {
		Pessoa p = rep.findById(peopleId).get();
		p.setEmail(email);
		
		rep.save(p);
		
		if(peopleSubscribers.containsKey(peopleId))
			peopleSubscribers.get(peopleId).next(p);
		
		return p;
	}
	
	public Publisher<Pessoa> onPeopleUpdated(Integer peopleId){
		return Flux.create(subscriber -> 
								peopleSubscribers.put(peopleId, subscriber.onDispose(() -> peopleSubscribers.remove(peopleId, subscriber))),
								FluxSink.OverflowStrategy.LATEST);
	}
} 
