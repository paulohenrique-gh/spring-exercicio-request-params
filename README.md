# Exercício Request Params

Desenvolver uma API utilizando Spring que permita a filtragem dinâmica de
dados em diferentes contextos ( pedidos e funcionários) por meio de parâmetros
de consulta (RequestParams).
1) Entidade Order
   Atributos: id, orderNumber, customerName, status, totalAmount, orderDate
   Filtros: orderNumber, customerName, status, minAmount, maxAmount,
   startDate, endDate

2) Entidade Employee
   Atributos: id, firstName, lastName, position, salary, hireDate, department, active

Filtros: firstName, department, minSalary, hiredAfter, hiredBefore, active;