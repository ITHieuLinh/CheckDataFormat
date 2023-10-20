package Repository;

import DataAccess.ValidateDAO;

public class ValidateRepository implements IValidateRepository {

    @Override
    public void Validate() {
        ValidateDAO.Instance().Validate();
    }

}
