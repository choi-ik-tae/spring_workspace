(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Frm01");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"writer\" type=\"STRING\" size=\"256\"/><Column id=\"message\" type=\"STRING\" size=\"3000\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("writer","73","58","130","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Writer");
            obj.set_border("1px solid");
            obj.set_font("normal 15pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.addChild(obj.name, obj);

            obj = new Static("message","73","120","130","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Message");
            obj.set_border("1px solid");
            obj.set_font("normal 15pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.addChild(obj.name, obj);

            obj = new Edit("editWriter","213","58","255","50",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Edit("editMessage","213","120","255","50",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            this.addChild(obj.name, obj);

            obj = new Button("btnSend","497","58","173","50",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("Send");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","500","125","170","45",null,null,null,null,null,null,this);
            obj.set_taborder("5");
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
        this.registerScript("Frm01.xfdl", function() {

        this.btnSend_onclick = function(obj,e)
        {
        	var writer = this.editWriter.value;
        	var message = this.editMessage.value;

        	// 서버통신할때 쓰는 문법, ajax 처럼 비동기통신 요청
        	var row = this.Dataset00.addRow();
        	this.Dataset00.setColumn(row, "writer",writer)
        	this.Dataset00.setColumn(row, "message",message);


        	var svcID = "insertSvc";
        	var svcURL = "/nxcr/insert.do";
        	var inDataset = "paramDS=Dataset00";
        	var outDataset = "";
        	var strArgs = "";
        	var callback = function() {};

        	this.transaction(svcID,svcURL,inDataset,outDataset,strArgs,callback);

        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.message.addEventHandler("onclick",this.writer00_onclick,this);
            this.btnSend.addEventHandler("onclick",this.btnSend_onclick,this);
            this.Calendar00.addEventHandler("onchanged",this.Calendar00_onchanged,this);
        };

        this.loadIncludeScript("Frm01.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
