package org.ranji.lemon.game;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

/**
 * 网格的子类
 * @author RanJi
 * 
 */
public class HelloShape extends SimpleApplication{
	
	
	public static void main(String[] args) {
		//-- 配置参数
		AppSettings settings = new AppSettings(true);
		settings.setTitle("一个方块");	//-- 标题
		settings.setResolution(1366, 768);	//-- 分辨率
		
		//-- 启动JME3程序
		HelloShape app = new HelloShape();
		app.setSettings(settings);	//-- 应用参数
		app.setShowSettings(false);		//-- 阻止配置参数的窗口出现
		//-- app.setDisplayFps(false);
		//-- app.setDisplayStatView(false);
		app.start();
	}
	/**
	 * 使用jme3自带的做好的子类网格---示例球体
	 */
	@Override
	public void simpleInitApp() {
		flyCam.setMoveSpeed(10);	//-- 设置摄像机移动速度
		
		//-- 创建物体使用球体网格【经线10条，纬线16条，半径2】
        Geometry geom = new Geometry("球体",new Sphere(10,16,2));
		
		//-- 创建材质
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //-- 显示网格线
        mat.getAdditionalRenderState().setWireframe(true);
        
        geom.setMaterial(mat);
        geom.center();	//-- 默认的位置居中
        
		//-- 将物体添加到场景图中
		rootNode.attachChild(geom);
		
	}
	
	
}
