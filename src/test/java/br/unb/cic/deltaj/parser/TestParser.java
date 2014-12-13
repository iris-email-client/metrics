package br.unb.cic.deltaj.parser;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestParser {

	private int errors;
	
	/*
	 * An error listener for computing the number of 
	 * errors found in a Delta compilation unit.
	 */
	class ErrorListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			errors++;
			super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		}
		
	}
	
	@Before
	public void setUp() {
		errors = 0;
	}

	private void parseFile(File file) throws FileNotFoundException, IOException {
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
		
		DeltaLexer lexer = new DeltaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DeltaParser parser = new DeltaParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorListener());
		parser.deltaCompilationUnit();
	}
	
	public List<File> listAllDeltaFiles(File baseDir) throws Exception {
		List<File> res = new ArrayList<File>();
		
		File deltaFiles[] = baseDir.listFiles(new FileFilter() {	
			@Override
			public boolean accept(File pathname) {
				return (pathname.isDirectory() && !pathname.getName().startsWith(".")) || pathname.getName().endsWith("deltaj");
			}
		});
		
		for(File f: deltaFiles) {
			if(f.isDirectory()) {
				res.addAll(listAllDeltaFiles(f));
			}
			else {
				res.add(f);
			}
		}
		return res;
	}
	
	@Test
	public void testAllDeltaFiles() {
		boolean erro = false;
		try {
			File f = new File(getClass().getResource("/deltas").toURI());
			for (File file : listAllDeltaFiles(f)) {
				System.out.print("Parsing delta file " + file.getName());
				parseFile(file);
				if(errors == 0) {
					System.out.println(" Ok");
				}
				else {
					erro = true;
				}
			}
			Assert.assertFalse(erro);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
