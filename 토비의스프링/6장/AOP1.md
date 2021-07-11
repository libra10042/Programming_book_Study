## AOP

> AOP는 IoC/DI, 서비스 추상화와 더불어 스프링의 3대 기반 기술의 하나다. 
> 스프링에 적용된 가장 인기 있는 AOP 의 적용 대상은 바로 선언적 트랜잭션 기능이다.


###### 비지니스 로직과 트랜잭션 경계설정의 분리 
```

public void upgradeLevels() throws Exception{
  TransactionStatus status = this.transactionManager
        .getTransaction(new DefaultTransactionDefinition());
        
  try{ 
      upgradeLevelsInternal();
      this.transactionManager.commit(status);
  } catch (Exception e){
      this.transactionManager.rollback(status);
      throw e; 
  }
}

private void upgradeLevelsInterval(){
  List<User> users = userDao.getAll();
  for(User user : users){
      if(canUpgradeLevel(user){
          upgradeLevel(user);
      }
  }
}

```

###### 트랜잭션이 적용된 UserServiceTx
```
public class UserServiceTx implements UserService{
    UserService userService;
    PlatformTransactionManager transactionManager; 
    
    public void setTransactionManager { 
        PlatformTransactionManager transactionManager){ 
          this.transactionManager = transactionManager'
    }
    
    public void setUserService(UserService userService){
        this.userService = userService; 
    }
    
    public void add(User user){
        this.userService.add(user);
    }
    
    public void upgradeLevel(){
        TransactionStatus status = this.transactionManager
          .getTransaction(new DefaultTransactionDefinition());
    
        try {
            userService.upgradeLevels();
            
            this.transactionManager.commit(status);
        
        } catch(RuntimeException e){
            this.transactionManager.rollback(status);
            throws e; 
        }  
    }
}
```

### 트랜잭션 분리에 따른 테스트 수정. 

###### 목 오브젝트 설정이 필요한 테스트 코드 수정. 

```
@Test
public void upgradeLevels() throws Exception {
    MockMailSender mockMailSender = new MockMailSender();
    userServiceImpl.setMailSender(mockMailSender);
}
```


###### 분리된 텥스트 기능이 포함되도록 수정한 upgradeAllOrNoting()
```
@Test
public void upgradeAllOrNothing() throws Exception {
    TestUserServer testUserService = new TestUserService(user.get(3).getId());
    testUserService.setUserDao(userDao);
    testUserService.setMailSender(mailSender);
    
    UserServiceTx txUserService = new UserServiceTx();
    txUserService.setTransactionManager(transactionManager);
    txUserService.setUserService(testUserService);
    
    userDao.deleteAll();
    for(User user : users) userDao.add(user);
    
    try {
    
    }
    ...
}
```

----
### 고립 단위 테스트 
> 가장 편하고 좋은 테스트 방법은 가능한 한 작은 단위로 쪼개서 테스트하는 것이다.
> 하지만 작은 단위로 테스트하고 싶어도 그럴 수 없는 경우가 많다.

