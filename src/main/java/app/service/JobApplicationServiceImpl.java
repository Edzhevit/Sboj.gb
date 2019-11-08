package app.service;

import app.domain.entities.JobApplication;
import app.domain.models.service.JobApplicationServiceModel;
import app.repository.JobApplicationRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobApplicationServiceImpl(JobApplicationRepository applicationRepository, ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(JobApplicationServiceModel job) {
        this.applicationRepository.save(this.modelMapper.map(job, JobApplication.class));
    }

    @Override
    public List<JobApplicationServiceModel> getAll() {
         return this.applicationRepository.findAll()
                .stream()
                .map(job -> this.modelMapper.map(job, JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobApplicationServiceModel getById(String id) {
        return this.modelMapper.map(this.applicationRepository.findById(id), JobApplicationServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.applicationRepository.delete(id);
    }
}
