# CRC Cards for Improved Order Processing System

**Class:** Order  
**Responsibilities:**  
- Store order data such as customer name, email, item, price, and date  
- Provide access to order details  
**Collaborators:**  
- None  

**Class:** OrderProcessor  
**Responsibilities:**  
- Coordinate the overall order processing workflow  
- Delegate pricing, storage, receipt printing, email notification, and logging tasks to other classes  
**Collaborators:**  
- Order  
- PricingService  
- ReceiptPrinter  
- OrderRepository  
- EmailService  
- OrderLogger  

**Class:** PricingService  
**Responsibilities:**  
- Calculate tax for an order  
- Apply discounts based on business rules  
- Compute the final total price  
**Collaborators:**  
- Order  

**Class:** ReceiptPrinter  
**Responsibilities:**  
- Format and print order receipts  
**Collaborators:**  
- Order  

**Class:** OrderRepository  
**Responsibilities:**  
- Save order data to persistent storage such as a file or database  
**Collaborators:**  
- Order  

**Class:** EmailService  
**Responsibilities:**  
- Send confirmation emails to customers  
**Collaborators:**  
- Order  

**Class:** OrderLogger  
**Responsibilities:**  
- Log order processing activities and events  
**Collaborators:**  
- Order  
- OrderProcessor