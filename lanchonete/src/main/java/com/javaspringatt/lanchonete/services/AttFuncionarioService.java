package com.javaspringatt.lanchonete.services;

@Service
public class AttFuncionarioService {

  private final AttFuncionarioRepository repo;

  public AttFuncionarioService(AttFuncionarioRepository repo) {
    this.repo = repo;
  }

  public AttFuncionariosModel salvar(AttFuncionariosModel f) {
    return repo.save(f);
  }

  public List<AttFuncionariosModel> listar() {
    return repo.findAll();
  }
}