(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("FrmIndex");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Button("Button00","84","75","188","65",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("toInput");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","360","75","188","65",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("toOutput");
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
        this.registerScript("FrmIndex.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	// 화면 바꿀 때 쓰는 문법 this.go()
        	this.go("Base::Frm01.xfdl");
        };

        this.Button01_onclick = function(obj,e)
        {
        	this.go("Base::Frm02.xfdl");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
        };

        this.loadIncludeScript("FrmIndex.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
