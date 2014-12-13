package br.unb.cic.metrics.visitors;

import br.unb.cic.deltaj.parser.DeltaBaseVisitor;
import br.unb.cic.deltaj.parser.DeltaParser.DeltaDeclarationContext;
import br.unb.cic.deltaj.parser.DeltaParser.DeltaMemberContext;
import br.unb.cic.metrics.model.Delta;

public class Visitor extends DeltaBaseVisitor<Void>{

	/**
	 * A visitor method for a DeltaDeclartion. 
	 */
	@Override
	public Void visitDeltaDeclaration(DeltaDeclarationContext ctx) {
		System.out.println(ctx.Identifier());
	
		return null;
	}

	private void visit(Delta delta, DeltaMemberContext member) {
		
	}	
}
