package com.encurtadorurl.encurtadorBack.controller;

import java.net.URI;

import com.encurtadorurl.encurtadorBack.entity.urlEncurtadaEntity;
import com.encurtadorurl.encurtadorBack.repository.UrlRepository;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@CrossOrigin(origins ={ "http://localhost:4200", "https://encurtador--url.herokuapp.com", "http://encurtador--url.herokuapp.com"})
@RequestMapping("")
public class PesquisaController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("encurtar")
    public @ResponseBody String encurtar(@RequestParam(name = "url", required = true) String url) throws Exception {
        try{
            String ans = RandomStringUtils.randomAlphanumeric(5); // Gerando uma string aleatoria com 5 digitos alphanumericos
            urlEncurtadaEntity novaUrl = new urlEncurtadaEntity(); //criando uma nova entidade para guardar a url
            novaUrl.setUrlEncurtada(ans);   //populando objeto criado com os campos da url encurtada com a url original
            novaUrl.setUrlOriginal(url);

            urlRepository.save(novaUrl);    // salvando no repositorio

            return ans; //retornando os 5 caracteres gerados para o frontend como texto
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao encurtar URL");
        }
    }

    @GetMapping("/{url}")
    public ResponseEntity<Void> redirecionar(@PathVariable(value="url") String url) throws Exception {
        try{
            urlEncurtadaEntity ans = urlRepository.findByurlEncurtada(url); //Buscando no banco a url correspondente a essa url encurtada
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(ans.getUrlOriginal())).build(); // construindo a resposta como um redirecionamento para a url encontrada
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao redirecionar URL");
        }
    }

}
