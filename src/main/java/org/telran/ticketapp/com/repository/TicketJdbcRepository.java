package org.telran.ticketapp.com.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.telran.ticketapp.com.model.Ticket;

import java.util.List;
import java.util.UUID;

@Repository
public class TicketJdbcRepository implements TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        String sql = "CREATE TABLE IF NOT EXISTS Ticket (\n" +
                "id varchar(64) primary key, \n" +
                "name varchar(64) not null,\n" +
                "price numeric(15,2)\n" +
                ");";
        jdbcTemplate.execute(sql);

//        jdbcTemplate.execute("truncate table Ticket");
//
//        String sqlInsert = "INSERT INTO Ticket(id, name, price) VALUES\n" +
//                "('0f9844bb-7b66-4f2d-8085-529effdfcb20','TicketOne', 535.0),\n" +
//                "('e9066357-60a0-4c73-b337-36b9cfa40373','TicketTwo',234.0);";
//        jdbcTemplate.execute(sqlInsert);
    }

    @Override
    public List<Ticket> getAll() {
        String sql = "SELECT * FROM TICKET"; // id, name, price
        List<Ticket> query = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Ticket.class));
        return query;
    }

    @Override
    public Ticket getById(String id) {
        String sql = "SELECT * FROM TICKET WHERE ID = ?";
        Ticket ticket = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Ticket.class), id);
        return ticket;
    }

    @Override
    public Ticket create(Ticket ticket) {
        Ticket createdTicket = new Ticket(ticket.getName(), ticket.getPrice());
        createdTicket.setId(UUID.randomUUID().toString());
        String sql = "INSERT INTO Ticket(id, name, price) VALUES " +
                "(?,?,?) ";
        int count = jdbcTemplate.update(sql,
                createdTicket.getId(), createdTicket.getName(), createdTicket.getPrice());
        return createdTicket;
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM TICKET WHERE ID = ?";
        int count = jdbcTemplate.update(sql, id);
    }
}
