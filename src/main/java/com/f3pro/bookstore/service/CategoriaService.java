package com.f3pro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f3pro.bookstore.domain.Categoria;
import com.f3pro.bookstore.repositories.CategoriaRepository;
import com.f3pro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não localizado! id: " + id + ", Tipo: " + Categoria.class.getName()));

    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, Categoria objTDO) {
        Categoria obj = findById(id);
        obj.setNome(objTDO.getNome());
        obj.setDescricao(objTDO.getDescricao());
        return repository.save(obj);

    }
}
