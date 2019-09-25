package br.com.codenation.centralerros.service.interfaces;

import br.com.codenation.centralerros.entity.User;

public interface UserServiceInterface {
    User findUserByCode(String userCode);
}
