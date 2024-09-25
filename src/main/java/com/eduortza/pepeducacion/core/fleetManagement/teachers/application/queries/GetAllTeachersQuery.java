package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.queries;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.application.IQuery;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.List;

public class GetAllTeachersQuery implements IQuery<Void, List<Teacher>> {
    private final ITeachersRepository repository;

    public GetAllTeachersQuery(ITeachersRepository repository) {
       this.repository = repository;
    }

    @Override
    public Result<List<Teacher>> query(Void params){
        return Result.success(repository.findAll());
    }
}
