package jp.sourceforge.mergedoc;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.progress.IProgressConstants;

public class PleiadesJavaPerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

 		String editorArea = layout.getEditorArea();

		IFolderLayout output = layout.createFolder("output", IPageLayout.LEFT, 0.5f, editorArea);
		//output.addView(IPageLayout.ID_PROBLEM_VIEW); // 変更: 問題 → マーカー
		output.addView("org.eclipse.ui.views.AllMarkersView");
		output.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
		output.addPlaceholder(JavaUI.ID_JAVADOC_VIEW);
		output.addPlaceholder(JavaUI.ID_SOURCE_VIEW);
		output.addPlaceholder("org.eclipse.jdt.callhierarchy.view");
		output.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
		output.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		output.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);
		output.addPlaceholder(IDebugUIConstants.ID_BREAKPOINT_VIEW);
		output.addPlaceholder(IDebugUIConstants.ID_VARIABLE_VIEW);

		IFolderLayout explorer = layout.createFolder("explorer", IPageLayout.TOP, 0.6f, "output");
		explorer.addView(JavaUI.ID_PACKAGES);
		explorer.addView(IPageLayout.ID_PROJECT_EXPLORER);
		explorer.addPlaceholder(JavaUI.ID_TYPE_HIERARCHY);

		IFolderLayout outline = layout.createFolder("outline", IPageLayout.RIGHT, 0.51f, "explorer");
		outline.addView(IPageLayout.ID_OUTLINE);
		outline.addPlaceholder("org.eclipse.team.sync.views.SynchronizeView");
		outline.addPlaceholder("org.eclipse.buildship.ui.views.executionview");
		outline.addPlaceholder("org.eclipse.ui.views.ProgressView");
		outline.addPlaceholder(IDebugUIConstants.ID_DEBUG_VIEW);

		IFolderLayout launch = layout.createFolder("launch", IPageLayout.BOTTOM, 0.5f, "outline");
		launch.addView("org.eclipse.debug.ui.launchView");
		launch.addView("org.eclipse.buildship.ui.views.taskview");
		launch.addView("org.eclipse.wst.server.ui.ServersView");
		launch.addView("org.springframework.ide.eclipse.boot.dash.views.BootDashView");

		// ツールバーのアイコン・セット
		layout.addActionSet(JavaUI.ID_ACTION_SET);
		layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
		layout.addActionSet("org.eclipse.wst.web.ui.wizardsActionSet");
		//layout.addActionSet("org.eclipse.jst.j2ee.J2eeMainActionSet"); // 頻度低のため使用しない

		// 新規作成ウィザード - プロジェクト
		layout.addNewWizardShortcut("org.eclipse.buildship.ui.wizard.project.creation");
		layout.addNewWizardShortcut("org.eclipse.m2e.core.wizards.Maven2ProjectWizard");
		layout.addNewWizardShortcut("org.springsource.ide.eclipse.commons.gettingstarted.wizard.boot.NewSpringBootWizard");
		layout.addNewWizardShortcut("org.springsource.ide.eclipse.gettingstarted.wizards.import.generic.newalias");
		layout.addNewWizardShortcut("org.eclipse.jst.servlet.ui.project.facet.WebProjectWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard");

		// 新規作成ウィザード - ファイル作成ウィザード
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard");
		// 簡単に Java 要素のみ制限できないため有効にしない、ツールバーからは起動可能、Jakarta 未対応
		//layout.addNewWizardShortcut("org.eclipse.jst.servlet.ui.internal.wizard.AddServletWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewRecordCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewJavaWorkingSetWizard");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
		layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");

		layout.addNewWizardShortcut("org.eclipse.wst.html.ui.internal.wizard.NewHTMLWizard");
		layout.addNewWizardShortcut("org.eclipse.wst.css.ui.internal.wizard.NewCSSWizard");
		layout.addNewWizardShortcut("org.eclipse.wst.jsdt.ui.NewJSWizard");

		// メニュー > ウィンドウ > ビューの表示
		layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
		layout.addShowViewShortcut(JavaUI.ID_TYPE_HIERARCHY);
		layout.addShowViewShortcut(JavaUI.ID_SOURCE_VIEW);
		layout.addShowViewShortcut(JavaUI.ID_JAVADOC_VIEW);
		layout.addShowViewShortcut(NewSearchUI.SEARCH_VIEW_ID);
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
		layout.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
		layout.addShowViewShortcut(IDebugUIConstants.ID_BREAKPOINT_VIEW);
		layout.addShowViewShortcut(IDebugUIConstants.ID_VARIABLE_VIEW);
		layout.addShowViewShortcut(IDebugUIConstants.ID_DEBUG_VIEW);
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView");
		layout.addShowViewShortcut("org.eclipse.buildship.ui.views.taskview");
		layout.addShowViewShortcut("org.eclipse.wst.server.ui.ServersView");
		layout.addShowViewShortcut("org.springframework.ide.eclipse.boot.dash.views.BootDashView");
		layout.addShowViewShortcut("de.babe.eclipse.plugins.quickREx.views.QuickRExView");
		layout.addShowViewShortcut("org.eclipse.debug.ui.launchView");

		// メニュー > ウィンドウ > パースペクティブを開く
		layout.addPerspectiveShortcut(JavaUI.ID_PERSPECTIVE);
		layout.addPerspectiveShortcut(IDebugUIConstants.ID_DEBUG_PERSPECTIVE);
	}
}
