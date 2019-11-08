package app.web.beans;

import app.domain.entities.Sector;
import app.domain.models.binding.JobCreateBindingModel;
import app.domain.models.service.JobApplicationServiceModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobCreateBean extends BaseBean{

    private JobCreateBindingModel bindingModel;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobCreateBean() {
    }

    @Inject
    public JobCreateBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.bindingModel = new JobCreateBindingModel();
    }

    public void create(){
        JobApplicationServiceModel job = this.modelMapper.map(this.bindingModel, JobApplicationServiceModel.class);
        Sector sector = null;

        try {
            sector = Sector.valueOf(this.bindingModel.getSector().toUpperCase());
        } catch (Exception e){
            this.redirect("/add-job");
        }

        job.setSector(sector);
        jobApplicationService.save(job);
        this.redirect("/home");


    }

    public JobCreateBindingModel getBindingModel() {
        return bindingModel;
    }

    public void setBindingModel(JobCreateBindingModel bindingModel) {
        this.bindingModel = bindingModel;
    }
}
