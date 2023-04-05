package  ma.enova.erdv.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.enova.erdv.bean.core.DroitUtilisateur;
import ma.enova.erdv.bean.history.DroitUtilisateurHistory;
import ma.enova.erdv.dao.criteria.core.DroitUtilisateurCriteria;
import ma.enova.erdv.dao.criteria.history.DroitUtilisateurHistoryCriteria;
import ma.enova.erdv.service.facade.admin.DroitUtilisateurAdminService;
import ma.enova.erdv.ws.converter.DroitUtilisateurConverter;
import ma.enova.erdv.ws.dto.DroitUtilisateurDto;
import ma.enova.erdv.zynerator.controller.AbstractController;
import ma.enova.erdv.zynerator.dto.AuditEntityDto;
import ma.enova.erdv.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.enova.erdv.zynerator.process.Result;

import org.springframework.web.multipart.MultipartFile;
import ma.enova.erdv.zynerator.dto.FileTempDto;

@Api("Manages droitUtilisateur services")
@RestController
@RequestMapping("/api/droitUtilisateur/")
public class DroitUtilisateurRestAdmin  extends AbstractController<DroitUtilisateur, DroitUtilisateurDto, DroitUtilisateurHistory, DroitUtilisateurCriteria, DroitUtilisateurHistoryCriteria, DroitUtilisateurAdminService, DroitUtilisateurConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all droitUtilisateurs")
    @GetMapping("")
    public ResponseEntity<List<DroitUtilisateurDto>> findAll() throws Exception {
        return super.findAll();
    }
    @ApiOperation("Updates the specified  droitUtilisateur")
    @PutMapping("")
    public ResponseEntity<DroitUtilisateurDto> update(@RequestBody DroitUtilisateurDto dto) throws Exception {
        return super.update(dto);
    }
    @ApiOperation("Finds a droitUtilisateur by id")
    @GetMapping("{id}")
    public ResponseEntity<DroitUtilisateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  droitUtilisateur")
    @PostMapping("")
    public ResponseEntity<DroitUtilisateurDto> save(@RequestBody DroitUtilisateurDto dto) throws Exception {
        return super.save(dto);
    }
    @ApiOperation("Delete list of droitUtilisateur")
    @DeleteMapping("/delete")
    public ResponseEntity<List<DroitUtilisateurDto>> delete(@RequestBody List<DroitUtilisateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified droitUtilisateur")
    @DeleteMapping("")
    public ResponseEntity<DroitUtilisateurDto> delete(@RequestBody DroitUtilisateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified droitUtilisateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple droitUtilisateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }
    @ApiOperation("find by droit id")
    @GetMapping("droit/id/{id}")
    public List<DroitUtilisateur> findByDroitId(@PathVariable Long id){
        return service.findByDroitId(id);
    }
    @ApiOperation("delete by droit id")
    @DeleteMapping("droit/id/{id}")
    public int deleteByDroitId(@PathVariable Long id){
        return service.deleteByDroitId(id);
    }
    @ApiOperation("find by utilisateur id")
    @GetMapping("utilisateur/id/{id}")
    public List<DroitUtilisateur> findByUtilisateurId(@PathVariable Long id){
        return service.findByUtilisateurId(id);
    }
    @ApiOperation("delete by utilisateur id")
    @DeleteMapping("utilisateur/id/{id}")
    public int deleteByUtilisateurId(@PathVariable Long id){
        return service.deleteByUtilisateurId(id);
    }
    @ApiOperation("Finds droitUtilisateurs by criteria")
    @PostMapping("listByCriteria")
    public ResponseEntity<List<DroitUtilisateurDto>> findByCriteria(@RequestBody DroitUtilisateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated droitUtilisateurs by criteria")
    @PostMapping("paginatedListByCriteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DroitUtilisateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports droitUtilisateurs by criteria")
    @PostMapping("exportDroitUtilisateurs")
    public ResponseEntity<InputStreamResource> export(@RequestBody DroitUtilisateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets droitUtilisateur data size by criteria")
    @PostMapping("getDroitUtilisateursDataSize")
    public ResponseEntity<Integer> getDataSize(@RequestBody DroitUtilisateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets droitUtilisateur history by id")
    @GetMapping("histDroitUtilisateur/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets droitUtilisateur paginated history by criteria")
    @PostMapping("paginatedListHistByCriteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DroitUtilisateurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports droitUtilisateur history by criteria")
    @PostMapping("exportDroitUtilisateursHist")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DroitUtilisateurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets droitUtilisateur history data size by criteria")
    @PostMapping("getHistDroitUtilisateursDataSize")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DroitUtilisateurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DroitUtilisateurRestAdmin (DroitUtilisateurAdminService service, DroitUtilisateurConverter converter) {
        super(service, converter);
    }


}