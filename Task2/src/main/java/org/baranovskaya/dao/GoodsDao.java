package org.baranovskaya.dao;

import org.baranovskaya.impl.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GoodsDao implements Dao<Goods> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Goods> getAll() {
        return jdbcTemplate.query("select * from Goods", new BeanPropertyRowMapper<>(Goods.class));
    }

    @Override
    public Optional<Goods> getById(int id) {
        return jdbcTemplate.query("select * from Goods where id = ?",
                new BeanPropertyRowMapper<>(Goods.class), id).stream().findAny();
    }
}
