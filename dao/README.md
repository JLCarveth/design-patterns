# Data Access Object

The Data Access Object (DAO) pattern provides a layer of abstraction between objects and a persistence mechanism. The DAO pattern separates the business logic and persistence logic, making the codebase more maintainable. Changes made to the business logic would not affect the DAO implementation, and modifying the DAO implementation does not affect the client providing the DAO interface remains the same. 

However, the Data Access Object pattern is often considered to be an anti-pattern. Since the DAO runs single queries at a time, calling multiple queries in succession would have a high performance cost. Without a DAO, those calls could be combined and the result returned in a single operation. 
    
Sources:
- https://www.oracle.com/technetwork/java/dataaccessobject-138824.html
- https://rrees.me/2009/07/11/the-dao-anti-patterns/