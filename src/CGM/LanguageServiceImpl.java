package CGM;

import java.util.List;
import java.util.Optional;

import com.cg.helix.persistence.exception.NoResultsException;

public class LanguageServiceImpl implements LanguageService {

	@Override
	public Language getLanguageById(String id) throws NoResultsException{
		// TODO Auto-generated method stub
		if (id == "aaa") {
			doThrow();
		}

		if (id == "gle")
			return new Language("gle", "Irish");
		return new Language("gle", "Irish");
	}

	@Override
	public List<Language> findLanguagesBySearchString(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	public void doThrow() throws NoResultsException {
		throw new com.cg.helix.persistence.exception.NoResultsException("some Message");
	}

}
