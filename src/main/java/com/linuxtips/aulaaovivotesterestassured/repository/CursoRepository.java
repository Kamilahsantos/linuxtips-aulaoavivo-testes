package com.linuxtips.aulaaovivotesterestassured.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.linuxtips.aulaaovivotesterestassured.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CursoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Curso salvar(Curso curso) {
        dynamoDBMapper.save(curso);
        return curso;
    }

    public Curso buscarPeloId(String cursoId) {
        return dynamoDBMapper.load(Curso.class, cursoId);
    }

    public String excluir(String cursoId) {
        Curso curso = dynamoDBMapper.load(Curso.class, cursoId);
        dynamoDBMapper.delete(curso);
        return "Curso excluido do cadastro";
    }

    public Curso atualizar(String cursoId, Curso curso) {
        dynamoDBMapper.save(new Curso
                        (cursoId,curso.getNome(),
                                curso.getValor(),
                                curso.getPessoaInstrutora()
                                ),
                new DynamoDBSaveExpression()
                        .withExpectedEntry("cursoId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(cursoId)
                                )));
        return curso;
    }

}
