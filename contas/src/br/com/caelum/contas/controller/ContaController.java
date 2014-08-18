package br.com.caelum.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/form")
	public String formulario() {
		return "conta/formulario";
	}

//	@RequestMapping("/adicionaConta")
//	public String adicionaConta(Conta conta) {
//		System.out.println("Conta adicionada é:" + conta.getDescricao());
//		new ContaDAO().adiciona(conta);
//		return "conta-adicionada";
//	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta) {
		System.out.println("tipo da conta:" + conta.getTipo());
	    ContaDAO dao = new ContaDAO();
	    dao.adiciona(conta);
	    return "redirect:/lista";
	}
	
//	@RequestMapping("lista")
//	public String lista(Model modelAndView) {
//		List<Conta> contas = new ContaDAO().lista();
//		System.out.println(contas);
//		modelAndView.addAttribute("todasContas", contas);
//		
//		return "conta/lista";
//	}
	
	@RequestMapping("/lista")
	public ModelAndView lista() {
	  List<Conta> contas = new ContaDAO().lista();
	  System.out.println(contas);
	  ModelAndView mv = new ModelAndView("conta/lista");
	  mv.addObject("todasContas", contas);
	  return mv;
	}
	
	@RequestMapping("/removeConta")
	public String removeConta(Conta conta) {
		new ContaDAO().remove(conta);
		return "redirect:/lista";
	}
	
	@RequestMapping("/mostraConta")
	public ModelAndView mostra(Long id) {
		ContaDAO dao = new ContaDAO();
		ModelAndView mv = new ModelAndView("conta/mostra");
		mv.addObject("conta", dao.buscaPorId(id));
		return mv;
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		new ContaDAO().altera(conta);
		return "redirect:lista";
	}
}
