package br.neitonjc.util;

import java.io.IOException;

public class GraphqlSchemaReaderUtil {
	public static String getSchemaFromFileName(final String filename) throws IOException {
	    return new String(
	        GraphqlSchemaReaderUtil.class.getClassLoader().getResourceAsStream("graphql/" + filename + ".graphql").readAllBytes());
	  }
}
