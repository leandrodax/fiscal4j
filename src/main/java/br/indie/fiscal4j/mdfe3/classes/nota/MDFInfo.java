package br.indie.fiscal4j.mdfe3.classes.nota;

import java.util.List;

import org.simpleframework.xml.*;

import br.indie.fiscal4j.DFBase;
import br.indie.fiscal4j.validadores.ListValidador;
import br.indie.fiscal4j.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 03/11/17. Informações do MDF-e.
 */
@Root(name = "infMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfo extends DFBase {
    private static final long serialVersionUID = 5215463851140624452L;

    public static final String IDENT = "MDFe";

    @Attribute(name = "Id")
    private String identificador;
    /**
     * Tipo Versão do MDF-e - 3.00.
     */
    @Attribute(name = "versao")
    private String versao = MDFe.VERSAO;

    @Element(name = "ide")
    private MDFInfoIdentificacao identificacao;

    @Element(name = "emit")
    private MDFInfoEmitente emitente;

    @Element(name = "infModal")
    private MDFInfoModal mdfInfoModal;

    /**
     * Informações dos Documentos fiscais vinculados ao manifesto.
     */
    @Element(name = "infDoc")
    private MDFInfoInformacoesDocumentos informacoesDocumentos;

    @ElementList(name = "seg", inline = true, required = false)
    private List<MDFInfoSeguro> seguro;

    @Element(name = "tot")
    private MDFInfoTotal infoTotal;

    @ElementList(entry = "lacres", inline = true, required = false)
    private List<MDFInfoLacre1A60> lacres;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<MDFInfoAutorizacaoDownload> autorizacaoDownload;

    @Element(name = "infAdic", required = false)
    private MDFInfoInformacoesAdicionais informacoesAdicionais;

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do MDF-e e precedida do literal "MDFe"
     */
    public void setIdentificador(final String identificador) {
        StringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = MDFInfo.IDENT + identificador;
    }

    /**
     * Retorna a chave de acesso a partir do identificador.
     *
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(MDFInfo.IDENT, "");
    }

    public MDFInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    public MDFInfoEmitente getEmitente() {
        return this.emitente;
    }

    /**
     * Identificação do Emitente do MDF-e
     */
    public void setEmitente(final MDFInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public List<MDFInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<MDFInfoAutorizacaoDownload> autorizacaoDownload) {
        ListValidador.tamanho10(autorizacaoDownload, "Autorizados para download do XML do DF-e");
        this.autorizacaoDownload = autorizacaoDownload;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute
     */
    public void setVersao(final String versao) {
        StringValidador.equals(MDFe.VERSAO, versao);
        this.versao = versao;
    }

    public void setIdentificacao(final MDFInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public MDFInfoModal getMdfInfoModal() {
        return this.mdfInfoModal;
    }

    public void setMdfInfoModal(final MDFInfoModal mdfInfoModal) {
        this.mdfInfoModal = mdfInfoModal;
    }

    public MDFInfoInformacoesDocumentos getInformacoesDocumentos() {
        return this.informacoesDocumentos;
    }

    public void setInformacoesDocumentos(final MDFInfoInformacoesDocumentos informacoesDocumentos) {
        this.informacoesDocumentos = informacoesDocumentos;
    }

    public MDFInfoTotal getInfoTotal() {
        return this.infoTotal;
    }

    public void setInfoTotal(final MDFInfoTotal infoTotal) {
        this.infoTotal = infoTotal;
    }

    public List<MDFInfoLacre1A60> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<MDFInfoLacre1A60> lacres) {
        this.lacres = lacres;
    }

    public MDFInfoInformacoesAdicionais getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public void setInformacoesAdicionais(final MDFInfoInformacoesAdicionais informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public List<MDFInfoSeguro> getSeguro() {
        return this.seguro;
    }

    public void setSeguro(final List<MDFInfoSeguro> seguro) {
        this.seguro = seguro;
    }
}
