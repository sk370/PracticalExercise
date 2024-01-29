package zyq.opcmilo.client;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zyq.opcmilo.client.pojo.entity.VirtualMachine;
import zyq.opcmilo.client.repository.VirtualMachineRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClientApplicationTests {
	@Resource
	private VirtualMachineRepository virtualMachineRepository;
	@Test
	void contextLoads() {
		List<VirtualMachine> all = virtualMachineRepository.findAll();
		all.forEach(virtualMachine -> System.out.println(virtualMachine));
	}

}
