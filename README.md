# PaymentSystem

http://localhost:8080/v1/customer/list -> list of all customers - GetMapping

http://localhost:8080/v1/customer/get/{id} -> get customer by id - GetMapping

http://localhost:8080/v1/customer/save -> need Customer object and save it - PostMapping

http://localhost:8080/v1/customer/update -> need Customer object and update it - PutMapping

http://localhost:8080/v1/customer/delete/{id} -> delete customer by id - DeleteMapping

http://localhost:8080/v1/invoice/list -> list of all invoices - GetMapping

http://localhost:8080/v1/invoice/list/{id} -> get invoice by id - GetMapping

http://localhost:8080/v1/invoice/save -> need Invoice object and save it - PostMapping

http://localhost:8080/v1/invoice/update -> need Invoice object and update it - PutMapping

http://localhost:8080/v1/invoice/delete/{id} -> delete invoice by id - DeleteMapping

http://localhost:8080/v1/invoice/getDebts/{subNo} -> gettin list of upaid invoices by subscriber number - GetMapping

http://localhost:8080/v1/payment/list -> list of all payments - GetMapping

http://localhost:8080/v1/payment/get/{id} -> get payment by id - GetMapping

http://localhost:8080/v1/payment/save/{subNo} -> pays all unpaid invoices with same subNo and save all changes - PostMapping

http://localhost:8080/v1/payment/update -> need Payment object and udpate it - PutMapping

http://localhost:8080/v1/payment/delete/{id} -> delete payment by id - DeleteMapping
