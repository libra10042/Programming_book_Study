## AOP

> AOP는 IoC/DI, 서비스 추상화와 더불어 스프링의 3대 기반 기술의 하나다. 
> 스프링에 적용된 가장 인기 있는 AOP 의 적용 대상은 바로 선언적 트랜잭션 기능이다.

##### 비지니스 로직과 트랜잭션 경계설정의 분리 
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

##### 트랜잭션이 적용된 UserServiceTx
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

