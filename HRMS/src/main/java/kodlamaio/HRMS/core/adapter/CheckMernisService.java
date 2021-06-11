package kodlamaio.HRMS.core.adapter;

import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CheckMernisService {

    boolean checkIfRealTcNo(Candidate candidate);
}
