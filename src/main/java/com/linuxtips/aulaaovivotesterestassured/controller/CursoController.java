package com.linuxtips.aulaaovivotesterestassured.controller;


import com.linuxtips.aulaaovivotesterestassured.model.Curso;
import com.linuxtips.aulaaovivotesterestassured.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvarCurso(@RequestBody Curso curso) {
        return cursoRepository.salvar(curso);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso buscarCursoPeloId(@PathVariable("id") String cursoId) {
        return cursoRepository.buscarPeloId(cursoId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCurso(@PathVariable("id") String cursoId) {
        return  cursoRepository.excluir(cursoId);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso atualizarCurso(@PathVariable("id") String cursoId,
                                            @RequestBody Curso curso) {
        return cursoRepository.atualizar(cursoId, curso);
    }

}
