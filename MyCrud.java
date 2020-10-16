
package com.raulburigo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/maratona")
public class MyCrud {
    
    List<Pessoa> pessoas = new ArrayList<Pessoa>();
    
    public void init() {
        pessoas.add(new Pessoa("Raul", "Junior", 1));
        pessoas.add(new Pessoa("Claudemir", "Master Jedi", 2));
        pessoas.add(new Pessoa("Kelton", "Senior", 3));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas")
    public Response listaPessoas() {
        init();
        return Response.status(Status.OK).entity(pessoas).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas")
    public Response criarPessoa(Pessoa pessoa) {
        init();
        pessoa.setMatricula(pessoas.size() + 1);
        pessoas.add(pessoa);
        return Response.status(Status.CREATED).entity(pessoa).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas/{matricula}")
    public Response pessoaByMatricula(@PathParam("matricula") int matricula) {
        init();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getMatricula() == matricula) {
                return Response.status(Status.OK).entity(pessoa).build();
            }
        }
        return Response.status(Status.NO_CONTENT).build();
    }
    

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas/{matricula}/delete")
    public Response removerPessoa(@PathParam("matricula") int matricula) {
        init();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getMatricula() == matricula) {
                pessoas.remove(pessoa);
                return Response.status(Status.OK).entity("pessoa excluída com sucesso").build();
            }
        }
        return Response.status(Status.NO_CONTENT).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas/{matricula}/update")
    public Response alterarPessoa(@PathParam("matricula") int matricula, Pessoa pessoaAtualizada) {
        init();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getMatricula() == matricula) {
                pessoa.setNome(pessoaAtualizada.getNome());
                pessoa.setPerfil(pessoaAtualizada.getPerfil());
                return Response.status(Status.OK).entity(pessoa).build();
            }
        }
        return Response.status(Status.NO_CONTENT).build();
    }

}
