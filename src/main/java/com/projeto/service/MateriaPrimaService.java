package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.MateriaPrima;
import com.projeto.repository.MateriaPrimaRepository;

@Service
public class MateriaPrimaService {
    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    public List<MateriaPrima> findAll() {
        return materiaPrimaRepository.findAll();
    }

    public Optional<MateriaPrima> findById(Integer id) {
        return materiaPrimaRepository.findById(id);
    }

    public MateriaPrima save(MateriaPrima materiaPrima) {
        return materiaPrimaRepository.saveAndFlush(materiaPrima);
    }

    public void delete(MateriaPrima materiaPrima) {
        materiaPrimaRepository.delete(materiaPrima);
    }

    public void deleteById(Integer id) {
        materiaPrimaRepository.deleteById(id);
    }

    public List<MateriaPrima> findByNomeOrDescricao(String texto) {
        return materiaPrimaRepository.findByNomeIsContainingIgnoreCaseOrDescricaoNutricionalIsContainingIgnoreCase(texto, texto);
    }
}
