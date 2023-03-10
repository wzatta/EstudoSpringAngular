/*package com.cilazatta.EstudoSpringAngular.config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.enums.Role;
import com.cilazatta.EstudoSpringAngular.repositories.HoldingRepository;
import com.cilazatta.EstudoSpringAngular.repositories.User00Repository;
import com.cilazatta.EstudoSpringAngular.services.HoldingService;
import com.cilazatta.EstudoSpringAngular.services.User00Service;
@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private User00Repository user00Repo;
	
	@Autowired
	private HoldingRepository holdRepo;
	
	@Autowired
	private User00Service user00Serv;
	
	@Autowired
	private HoldingService holdService;
	
	@Override
	public void run(String... args) throws Exception {
		
	
		List<User00DTO> listDto = new ArrayList<>();
		List<HoldingDTO> listHoldDto = new ArrayList<>();
		
		user00Repo.deleteAll();
		holdRepo.deleteAll();
		
		User00DTO wal1 = new User00DTO(null,"Waldyr Zatta Junior","00000000153","zatta","1234",true, true, Role.ADMIN);
		User00DTO edi1 = new User00DTO(null,"Edisilene Santos Zatta","00000000253","cila","1234",true, true, Role.USER);
		User00DTO mat1 = new User00DTO(null,"Mateus Santos Zatta","00000000353","santos","1234",true, true, Role.USER);
		
		List<User00DTO> list0User = new ArrayList<>(Arrays.asList(wal1,edi1,mat1));
		list0User.stream()
		.forEach(w-> {listDto.add(user00Serv.insertUser(w));});
		
		HoldingDTO hold1 = new HoldingDTO(null, "Tenenge-Tecnica Nacional de Engenharia S/A", "matriz", "21212213000101","São Paulo","SP",listDto.get(0));
		HoldingDTO hold2 = new HoldingDTO(null, "Construtora Norberto Odebrecht S/A", "matriz", "31212213000102","Salvador","BA",listDto.get(1));
		HoldingDTO hold3 = new HoldingDTO(null, "Montreal Engenharia s/a", "matriz", "41212213000502","Rio de Janeiro","RJ",listDto.get(2));
		
		List<HoldingDTO> listHolding = new ArrayList<>(Arrays.asList(hold1, hold2,hold3));
		listHolding.stream()
		.forEach(w->{listHoldDto.add(holdService.insertHolding(w));});
	
	}
}
*/