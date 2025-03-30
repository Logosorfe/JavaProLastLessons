package org.telran.ticketapp.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.model.Ticket;
import org.telran.ticketapp.com.service.TicketService;

import java.util.List;

//http://localhost:8080/tickets
//CRUD - Create Read, Update Delete
//REST - RESTFull api

//HTTP protocol - GET, POST, PUT, PATCH, DELETE
//GET - когда нужно прочитать информацию от сервера
//POST - когда передаем информацию на сервер для создания
//PUT - для изменения / обновления объекта (полностью)
//PATCH - для изменения / обновления объекта (его полей)
//DELETE - для удаления объекта

//REST :
//(R)get all tickets - GET по корневому адресу http://localhost:8080/tickets
//(R)get info by ticket (DFER343) - GET по корневому адресу+параметр в пути http://Localhost:8080/tickets/DFER343
//(C)create ticket - POST по корневому адресу http://localhost:8080/tickets
//(D)delete ticket - DELETE no по корневому адресу+параметр в пути http://Localhost:8080/tickets/DFER343


@RestController // @Controller + @ResponseBody (transfer object in answer)
@RequestMapping("tickets") // определяет путь по которому можно найти наш контроллер
public class TicketController {

    @Autowired
    private TicketService service;

    // /tickets //http://localhost:8080/tickets/
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public List<Ticket> getAll() {
        return service.getAll();
    }

    //http://localhost:8080/tickets/getTicketById/DFDFSDF434 -!!!!
    //url/hotels - get all , url/hotels/marriott

    // /tickets/{id} //http://localhost:8080/tickets/ADFWS23
    @GetMapping("/{id}")
    public Ticket getById(@PathVariable String id) {
        return service.getById(id);
    }

    //@PathVariable - данные передаются как часть адресной строки(пути)
    //http://Localhost:8080/tickets/ADFWS23

    //@RequestBody - данные передаются в теле запроса
    //http://localhost:8080/tickets/
    // + body (data)

    //@RequestParam - данные передаются как параметры в адресной строке
    //http://localhost:8080/tickets?name=Alex&surname=Alexeev

    // /tickets //http://localhost:8080/tickets/
    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.create(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        service.delete(id);
    }
}
