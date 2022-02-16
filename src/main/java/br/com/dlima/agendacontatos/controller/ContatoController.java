package br.com.dlima.agendacontatos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dlima.agendacontatos.domain.Contato;
import br.com.dlima.agendacontatos.service.ContatoService;

@Controller
public class ContatoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final int ROw_PER_PAGE = 5;
	
	@Autowired
	private ContatoService contatoService;
	
	@Value("${msg.title}")
	private String title;
	
	@GetMapping(value = {"/", "/index"})
	private String index(Model model) { ... } 
	
	@GetMapping(value = "/contacts")
    public String getContacts(Model model,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber) { ... }
 
    @GetMapping(value = "/contacts/{contactId}")
    public String getContactById(Model model, @PathVariable long contactId) { ... }
 
    @GetMapping(value = {"/contacts/add"})
    public String showAddContact(Model model) { ... }
 
    @PostMapping(value = "/contacts/add")
    public String addContact(Model model,
            @ModelAttribute("contact") Contato contact) { ... }
 
    @GetMapping(value = {"/contacts/{contactId}/edit"})
    public String showEditContact(Model model, @PathVariable long contactId) { ... }
    
    @PostMapping(value = {"/contacts/{contactId}/edit"})
    public String updateContact(Model model,
            @PathVariable long contactId,
            @ModelAttribute("contact") Contato contact) { ... }
 
    @GetMapping(value = {"/contacts/{contactId}/delete"})
    public String showDeleteContactById(
            Model model, @PathVariable long contactId) { ... }
    
    @PostMapping(value = {"/contacts/{contactId}/delete"})
    public String deleteContactById(
            Model model, @PathVariable long contactId) { ... }
	
}
