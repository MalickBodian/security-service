package sn.groupeisi.gestionsecurite.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.domaine.Role;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;
import sn.groupeisi.gestionsecurite.exception.RequestException;
import sn.groupeisi.gestionsecurite.mapping.AppRoleMapper;
import sn.groupeisi.gestionsecurite.repositories.AppRoleRepository;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.gestionsecurite.services.IAppRoleServiceService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "roles")
@AllArgsConstructor
public class AppRoleService implements IAppRoleServiceService {

    static AppRoleRepository appRoleRepository;
    static AppRoleMapper appRoleMapper;
    static MessageSource messageSource;

    public List<AppRoleEntity> findAll(){
            return StreamSupport.stream(appRoleRepository.findAll().spliterator(), false)
            .map(appRoleMapper::toRole)
                .collect(Collectors.toList());
}
    @Transactional(readOnly = true)
    public static Role update(String name, Role role) {
        return appRoleRepository.findByNameIgnoreCase(name)
             .map(entity -> {
                  /*     employeeRepository.findById(department.getResponsable().getId()).orElseThrow(() ->
                            new EntityNotFoundException(messageSource.getMessage("employee.notfound",
                                    new Object[]{department.getResponsable().getId()},
                                    Locale.getDefault())));*/
                    role.setName(name);
                    return appRoleMapper.toRole(appRoleRepository.save(appRoleMapper.fromRole(role)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound",
                        new Object[]{name},
                        Locale.getDefault())));
    }
    @Transactional
     public static Role save(Role role) {
        appRoleRepository.findByNameIgnoreCase(role.getName())
                 .ifPresent(entity -> {
                     throw new RequestException(messageSource.getMessage("role.exists", new Object[]{role.getName()},
                             Locale.getDefault()), HttpStatus.CONFLICT);
                 });
        return appRoleMapper.toRole(appRoleRepository.save(appRoleMapper.fromRole(role)));
    }


    @Cacheable(key = "#name")
    @Transactional(readOnly = true)
    public Role findByName(String name) {
        return appRoleMapper.toRole(appRoleRepository.findByNameIgnoreCase(name).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{name},
                        Locale.getDefault()))));
    }

    @Transactional
    public void delete(String name) {
        try {
            appRoleRepository.deleteById(name);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{name},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }


}
