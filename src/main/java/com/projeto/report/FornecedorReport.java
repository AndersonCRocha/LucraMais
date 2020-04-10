package com.projeto.report;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.bean.Fornecedor;
import com.projeto.service.FornecedorService;
import com.projeto.util.SistemaUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/login/report/Fornecedor")
public class FornecedorReport {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("")
	public void relatorioPdf(HttpServletRequest request,  HttpServletResponse response) throws JRException, SQLException, IOException {
		
		InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/fornecedores.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("TITULO", "Relatório de fornecedores");
		InputStream logo = this.getClass().getResourceAsStream("/static/img/logo.png");
		InputStream logoCafeBauer = this.getClass().getResourceAsStream("/static/img/logoCafeBauer.png");
		parametros.put("LOGO", logo); 
		parametros.put("LOGOCAFEBAUER", logoCafeBauer); 
		parametros.put("USUARIOLOGADO", SistemaUtil.getUsuarioLogado(request).getNome());
		
		List<Fornecedor> listaFornecedores = fornecedorService.findAll();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(listaFornecedores));

		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=Fornecedores.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
}

