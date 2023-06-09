package chinh.nguyen.service.category;

import chinh.nguyen.model.Category;
import chinh.nguyen.model.User;
import chinh.nguyen.repository.ICategoryRepository;
import chinh.nguyen.security.userprincipal.UserDetailsServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceIMPL implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private UserDetailsServiceIMPL userDetailsServiceIMPL;
    @Override
    public void save(Category category) {
        User user =  userDetailsServiceIMPL.getCurrentUser();
        category.setUser(user);
        categoryRepository.save(category);
    }
}
