/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.jefrypardo.portafolio.redisclient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeffry
 */
@Repository
public interface ChatHistoryRedisRepository extends CrudRepository<ChatHistoryRedis, String> {}