package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.CriticRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Critic;
import domain.Message;
import domain.SocialIdentity;

@Service
@Transactional
public class CriticService {
	// Managed repository -----------------------------------------------------
	
			@Autowired
			private CriticRepository criticRepository;
			
			// Supporting services ----------------------------------------------------

			
			// Constructors -----------------------------------------------------------
			
			public CriticService(){
				super();
			}
			
			// Simple CRUD methods ----------------------------------------------------
			
			public Critic create() {
				UserAccount userAccount = new UserAccount();
				List<Authority> authorities=new ArrayList<Authority>();
				Authority au = new Authority();
				au.setAuthority("CRITIC");
				authorities.add(au);
				userAccount.setAuthorities(authorities);
				
				Critic result;
				result = new Critic();
				result.setUserAccount(userAccount);
				
				Collection<SocialIdentity> socialIdentities = new ArrayList<SocialIdentity>();
				Collection<Message> sendedMessages = new ArrayList<Message>();
				Collection<Message> receivedMessages = new ArrayList<Message>();
				
				result.setSendedMessages(sendedMessages);
				result.setReceivedMessages(receivedMessages);
				result.setSocialIdentities(socialIdentities);
				
				return result;
			}

			public Collection<Critic> findAll() {
				Collection<Critic> result;

				result = criticRepository.findAll();
				Assert.notNull(result);

				return result;
			}

			public Critic findOne(int criticId) {
				Critic result;

				result = criticRepository.findOne(criticId);
				Assert.notNull(result);

				return result;
			}

			public Critic save(Critic critic) {
				
				Assert.notNull(critic);
				
				Critic result;

				result = criticRepository.save(critic);
				
				return result;
			}

			public void delete(Critic critic) {
				Assert.notNull(critic);
				Assert.isTrue(critic.getId() != 0);

				criticRepository.delete(critic);
			}
			
			// Other business methods -------------------------------------------------
			
			public Critic findByPrincipal() {
				Critic result;
				UserAccount userAccount;
			
				userAccount = LoginService.getPrincipal();
				Assert.notNull(userAccount);
				result = criticRepository.findByUserAccountId(userAccount.getId());
				Assert.notNull(result);

				return result;
			}
			
			public Critic findByUserAccountId(int userAccount){
				Assert.notNull(userAccount);
				Critic result;
				
				result = criticRepository.findByUserAccountId(userAccount);
				
				return result;
			}
			
}
