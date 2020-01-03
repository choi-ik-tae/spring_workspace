(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Frm02");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"seq\" type=\"INT\" size=\"4\"/><Column id=\"writer\" type=\"STRING\" size=\"256\"/><Column id=\"message\" type=\"STRING\" size=\"3000\"/><Column id=\"write_date\" type=\"DATETIME\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","80","50","590","300",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("Dataset00");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"46\"/><Column size=\"80\"/><Column size=\"302\"/><Column size=\"160\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"seq\"/><Cell col=\"1\" text=\"writer\"/><Cell col=\"2\" text=\"message\"/><Cell col=\"3\" text=\"write_date\"/></Band><Band id=\"body\"><Cell text=\"bind:seq\"/><Cell col=\"1\" text=\"bind:writer\"/><Cell col=\"2\" text=\"bind:message\"/><Cell col=\"3\" text=\"bind:write_date\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Frm02.xfdl", function() {

        this.Frm02_onload = function(obj,e)
        {
        	var svcID = "selectSvc";
        	var svcURL = "/nxcr/select.do";
        	var inDataset = "";
        	var outDataset = "Dataset00=respDS";
        	var strArgs = "";
        	var callback = function() {};

        	this.transaction(svcID,svcURL,inDataset,outDataset,strArgs,callback);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Frm02_onload,this);
        };

        this.loadIncludeScript("Frm02.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
