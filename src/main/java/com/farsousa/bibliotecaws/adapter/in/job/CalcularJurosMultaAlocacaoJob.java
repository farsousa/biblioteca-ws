package com.farsousa.bibliotecaws.adapter.in.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;

@Component
public class CalcularJurosMultaAlocacaoJob {	
	
	private final ProcessarAlocacaoPortIn processarAlocacaoPortIn;
	
	public CalcularJurosMultaAlocacaoJob(ProcessarAlocacaoPortIn processarAlocacaoPortIn) {
		this.processarAlocacaoPortIn = processarAlocacaoPortIn;
	}
 	
	
	@Scheduled(fixedRate = 100000)
    public void myScheduledMethod() {
        System.out.println("Verificando pendencias em todos método agendado...");
        try {
        	processarAlocacaoPortIn.verificarPendenciasTodos();
        	System.out.println("Pendencias atualizadas!");
        }catch(NaoEncontradoException e) {
        	System.out.println(e.getMessage());
        }
    }

}
