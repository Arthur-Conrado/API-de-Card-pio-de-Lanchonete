package com.javaspringatt.lanchonete.controller;
import com.javaspringatt.lanchonete.models.AttFuncionariosModel;
import com.javaspringatt.lanchonete.service.AttFuncionarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/funcionarios")
public class AttFuncionarioController {

  private final AttFuncionarioService service;

  public AttFuncionarioController(AttFuncionarioService service) {
    this.service = service;
  }

  @PostMapping
  public AttFuncionariosModel criar(@RequestBody AttFuncionariosModel f) {
    return service.salvar(f);
  }

  @GetMapping
  public List<AttFuncionariosModel> listar() {
    return service.listar();
  }
}