package br.com.gustavorodrigues.controller;

import java.util.Arrays;
import java.util.List;

import br.com.gustavorodrigues.model.Sexo;
import br.com.gustavorodrigues.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gustavorodrigues.repository.Usuarios;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private Usuarios usuarios;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ModelAttribute("mensagem")
	public ModelAndView salvar(Usuario usuario) {
		usuarios.save(usuario);
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject("mensagem", "Usuario salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	@ModelAttribute("usuarios")
	public ModelAndView pesquisar() {
		List<Usuario> todosUsuarios = usuarios.findAll();
		ModelAndView mv = new ModelAndView("PesquisaUsuarios");
		mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	
	@ModelAttribute("todosSexoUsuarios")
	public List<Sexo> todosStatusTitulo() {
		return Arrays.asList(Sexo.values());
	}
	
}
