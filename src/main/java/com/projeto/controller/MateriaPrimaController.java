package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.projeto.bean.Produto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.MateriaPrima;
import com.projeto.service.FornecedorService;
import com.projeto.service.MateriaPrimaService;

@Controller
@RequestMapping(value = "/login/crud/MateriaPrima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("criar")
    public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false) Integer id) {

        if (id != null) {
            Optional<MateriaPrima> materiaPrima = materiaPrimaService.findById(id);
            if (materiaPrima.isPresent()) {
                MateriaPrima form = materiaPrima.get();
                request.setAttribute("materiaPrima", form);
            }
        }
        request.setAttribute("listaFornecedor", fornecedorService.findAll());
        request.setAttribute("page", "materiaPrimaEntrada.jsp");
        return new ModelAndView("/login/crud/base");
    }

    @GetMapping("")
    public ModelAndView listar(HttpServletRequest request) {
        String texto = request.getParameter("q");
        List<MateriaPrima> listaMateriaPrima = StringUtils.isNotBlank(texto)
                ? materiaPrimaService.findByNomeOrDescricao(texto) : materiaPrimaService.findAll();
        request.setAttribute("listaMateriaPrima", listaMateriaPrima);
        request.setAttribute("page", "materiaPrimaListagem.jsp");
        return new ModelAndView("/login/crud/base");
    }

    @PostMapping("salvar")
    public ModelAndView salvar(MateriaPrima materiaPrima, RedirectAttributes redirectAttributes) {
        try {
            materiaPrimaService.save(materiaPrima);
            redirectAttributes.addFlashAttribute("sucesso", "MateriaPrima salva com sucesso");
            return new ModelAndView("redirect:/login/crud/MateriaPrima");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("erro", "Erro : " + e.getMessage());
        }
        redirectAttributes.addFlashAttribute("materiaPrima", materiaPrima);
        return new ModelAndView("redirect:/login/crud/MateriaPrima/criar");
    }

    @GetMapping("excluir")
    public ModelAndView excluir(@RequestParam(name = "id", required = true) Integer id, RedirectAttributes redirectAttributes) {

        if (id != null) {
            try {
                materiaPrimaService.deleteById(id);
                redirectAttributes.addFlashAttribute("sucesso", "MateriaPrima deletada com sucesso");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir essa materiaPrima.");
            }
        }

        return new ModelAndView("redirect:/login/crud/MateriaPrima");
    }
}


