package br.com.abcdario.controlfrota.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.abcdario.controlfrota.enums.TiposRelatorio;

public final class GeradorRelatorio {

	private static final String MIME_TYPE_RELATORIO = "application/pdf";

	@SuppressWarnings("rawtypes")
	public static StreamedContent gerarRelatorioWebPDF(TiposRelatorio tipoRelatorio, String caminhoRelatorio,
			String tituloArquivo, Map<String, Object> parametros, Collection colecao) {

		String caminhoRealRelatorio = FacesUtil.getDiretorioReal(caminhoRelatorio);
		InputStream input = null;

		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(caminhoRealRelatorio);

			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(colecao);

			JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, datasource);
			JRExporter exporter = null;

			if (tipoRelatorio == TiposRelatorio.PDF)
				exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();

			if (tipoRelatorio == TiposRelatorio.HTML) {
				exporter = new net.sf.jasperreports.engine.export.JRHtmlExporter();
				exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, false);
			}

			if (tipoRelatorio == TiposRelatorio.XLS)
				exporter = new net.sf.jasperreports.engine.export.JRXlsExporter();

			if (tipoRelatorio == TiposRelatorio.CSV)
				exporter = new net.sf.jasperreports.engine.export.JRCsvExporter();

			if (tipoRelatorio == TiposRelatorio.TXT)
				exporter = new net.sf.jasperreports.engine.export.JRTextExporter();

			if (tipoRelatorio == TiposRelatorio.RTF)
				exporter = new net.sf.jasperreports.engine.export.JRRtfExporter();

			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			input = new ByteArrayInputStream(output.toByteArray());
		} catch (JRException ex) {
			Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
		}

		return new DefaultStreamedContent(input, MIME_TYPE_RELATORIO, tituloArquivo);

	}
}
