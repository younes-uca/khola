package  ma.enova.erdv.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.enova.erdv.bean.core.Droit;
import ma.enova.erdv.bean.history.DroitHistory;
import ma.enova.erdv.dao.criteria.core.DroitCriteria;
import ma.enova.erdv.dao.criteria.history.DroitHistoryCriteria;
import ma.enova.erdv.service.facade.admin.DroitAdminService;
import ma.enova.erdv.ws.converter.DroitConverter;
import ma.enova.erdv.ws.dto.DroitDto;
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

@Api("Manages droit services")
@RestController
@RequestMapping("/api/droit/")
public class DroitRestAdmin  extends AbstractController<Droit, DroitDto, DroitHistory, DroitCriteria, DroitHistoryCriteria, DroitAdminService, DroitConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all droits")
    @GetMapping("")
    public ResponseEntity<List<DroitDto>> findAll() throws Exception {
        return super.findAll();
    }
    @ApiOperation("Updates the specified  droit")
    @PutMapping("")
    public ResponseEntity<DroitDto> update(@RequestBody DroitDto dto) throws Exception {
        return super.update(dto);
    }
    @ApiOperation("Finds a droit by id")
    @GetMapping("{id}")
    public ResponseEntity<DroitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  droit")
    @PostMapping("")
    public ResponseEntity<DroitDto> save(@RequestBody DroitDto dto) throws Exception {
        return super.save(dto);
    }
    @ApiOperation("Delete list of droit")
    @DeleteMapping("/delete")
    public ResponseEntity<List<DroitDto>> delete(@RequestBody List<DroitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified droit")
    @DeleteMapping("")
    public ResponseEntity<DroitDto> delete(@RequestBody DroitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified droit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple droits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }
    @ApiOperation("Finds droits by criteria")
    @PostMapping("listByCriteria")
    public ResponseEntity<List<DroitDto>> findByCriteria(@RequestBody DroitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated droits by criteria")
    @PostMapping("paginatedListByCriteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DroitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports droits by criteria")
    @PostMapping("exportDroits")
    public ResponseEntity<InputStreamResource> export(@RequestBody DroitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets droit data size by criteria")
    @PostMapping("getDroitsDataSize")
    public ResponseEntity<Integer> getDataSize(@RequestBody DroitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets droit history by id")
    @GetMapping("histDroit/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets droit paginated history by criteria")
    @PostMapping("paginatedListHistByCriteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DroitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports droit history by criteria")
    @PostMapping("exportDroitsHist")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DroitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets droit history data size by criteria")
    @PostMapping("getHistDroitsDataSize")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DroitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DroitRestAdmin (DroitAdminService service, DroitConverter converter) {
        super(service, converter);
    }


}