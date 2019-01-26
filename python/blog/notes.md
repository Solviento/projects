
- This input button with id "fileUpload" should handle how below img src is made in jquery call
``` HTML
<span class="btn btn-primary btn-file">
  Browse&hellip;
  <input type="file" id="fileupload" name="file" multiple>
</span>
```
- Once image has been uploaded, src of below should be changed, this then gets pulled by app.py (at least for now)
- img tag is used to create a mini preview while input is used to allow flask mysql to pull data back into db
``` HTML
<img id="imgUpload" style="width: 140px; height: 140px;" class="img-thumbnail">
<input type="hidden" name="newfilePath"id="newfilePath"></input>
```
