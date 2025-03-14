package ru.nsu.lisitsin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.lisitsin.dao.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
