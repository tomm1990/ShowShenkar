package il.ac.shenkar.showshenkar.backend.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.memcache.ErrorHandlers;
import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import il.ac.shenkar.showshenkar.backend.OfyService;
import il.ac.shenkar.showshenkar.backend.model.Project;

/**
 * Created by:  Gregory Kondratenko on 10/06/2016.
 * Description: Backend api for app projects
 */
@Api(
        name = "projectApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.showshenkar.shenkar.ac.il",
                ownerName = "backend.showshenkar.shenkar.ac.il",
                packagePath=""
        )
)
public class ProjectApi {

    @ApiMethod(
            name = "getProject",
            path = "projectApi/{id}",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public Project getProject(@Named("id") Long id){
        return OfyService.ofy().load().type(Project.class).id(id).now();
    }

    @ApiMethod(
            name = "getProjectsByDepartment",
            path = "projectApi/ByDepartment/{department}",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<Project> getProjectsByDepartment(@Named("department") String department){

        MemcacheService syncCache = MemcacheServiceFactory.getMemcacheService();
        syncCache.setErrorHandler(ErrorHandlers.getConsistentLogAndContinue(Level.INFO));

        String key = String.format("getProjectsByDepartment_%s",department);

        if (syncCache.contains(key)){
            return (List<Project>) syncCache.get(key);
        }

        List<Project> projects =  OfyService.ofy().load().type(Project.class).filter("department", department).list();

        Expiration expiration =  Expiration.byDeltaSeconds((int) TimeUnit.HOURS.toSeconds(3));
        syncCache.put(key,projects,expiration);

        return projects;
    }

    @ApiMethod(
            name = "getProjects",
            path = "projectApi",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<Project> getProjects(){
        return OfyService.ofy().load().type(Project.class).list();
    }

    @ApiMethod(
            name = "setProject",
            path = "projectApi",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public Project setProject(Project project){
        if (project == null){
            throw new IllegalStateException("Project is null");
        }

        if (project.getId() != null) {
            throw new IllegalStateException("Project already exits");
        }

        OfyService.ofy().save().entity(project).now();
        return project;
    }

    @ApiMethod(
            name = "deleteProject",
            path = "projectApi/{id}",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public Project deleteProject(@Named("id") String id){
        //TODO: update stub
        return null;
    }

    @ApiMethod(
            name = "updateProject",
            path = "projectApi/{id}",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    Project updateProject(@Named("id") String id){
        //TODO: update stub
        return null;
    }

}
