package br.indie.fiscal4j.nfe400.transformers;

import br.indie.fiscal4j.nfe400.classes.nota.NFViaTransporteInternacional;
import org.simpleframework.xml.transform.Transform;

public class NFViaTransporteInternacionalTransformer implements Transform<NFViaTransporteInternacional> {

    @Override
    public NFViaTransporteInternacional read(final String codigo) {
        return NFViaTransporteInternacional.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFViaTransporteInternacional via) {
        return via.getCodigo();
    }
}